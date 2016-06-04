<#-- if，elseif,else指令-->
<#if animals.python.price < animals.elephant.price>
  Pythons are cheaper than elephants today.
<#elseif animals.elephant.price < animals.python.price>
  Elephants are cheaper than pythons today.
<#else>
  Elephants and pythons cost the same today.
</#if>
<#-- list指令，这种情况下如果animals为空，依然会打印出一个空表格出来-->
<p>We have these animals:
<table border=1>
  <#list animals as animal>
    <tr><td>${animal.name}<td>${animal.price} Euros
  </#list>
</table>
<#-- list指令，避免了animals为空的情况-->
<#--<#list animals>
  <table border=1>
    <#items as animal>
      <tr><td>${animal.name}<td>${animal.price} Euros
    </#items>
  </table>
</#list>-->

<#--打印连接，效果为<p>Fruits: orange, banana，也可通过<p>Fruits: ${fruits?join(", ", "None")}实现-->
<p>Fruits: <#list misc.fruits as fruit>${fruit},None</#list>
<#-- include指令在页面中插入其他文件-->
<#include "/copyright_footer.html">
<#-- 内建函数-->
user?html 给出 user 的HTML转义版本， 比如 & 会由 &amp; 来代替。

user?upper_case 给出 user 值的大写版本 (比如 "JOHN DOE" 来替代 "John Doe")

animal.name?cap_first 给出 animal.name 的首字母大写版本(比如 "Mouse" 来替代 "mouse")

user?length 给出 user 值中 字符的数量(对于 "John Doe" 来说就是8)

animals?size 给出 animals 序列中 项目 的个数(我们示例数据模型中是3个)

如果在 <#list animals as animal> 和对应的 </#list> 标签中：animal?index 给出了在 animals 中基于0开始的 animal的索引值,
animal?counter 也像 index， 但是给出的是基于1的索引值,animal?item_parity 基于当前计数的奇偶性，给出字符串 "odd" 或 "even"。
在给不同行着色时非常有用，比如在 <td class="${animal?item_parity}Row">中。

animal.protected?string("Y", "N") 基于 animal.protected 的布尔值来返回字符串 "Y" 或 "N"。

animal?item_cycle('lightRow','darkRow') 是之前介绍的 item_parity 更为常用的变体形式。

fruits?join(", ") 通过连接所有项，将列表转换为字符串， 在每个项之间插入参数分隔符(比如 "orange,banana")

user?starts_with("J") 根据 user 的首字母是否是 "J" 返回布尔值true或false

<#--处理不存在的变量，对于freemarker而言为空和不存在是同一回事-->
<h1>Welcome ${user!"visitor"}!</h1>表示当 user 不存在于数据模型时, 模板将会将 user 的值表示为字符串 "visitor"。(当 user 存在时， 模板就会表现出 ${user} 的值)
<#if user??><h1>Welcome ${user}!</h1></#if>表示 如果 user 变量不存在的话将会忽略整个问候的代码段：

关于多级访问的变量，比如 animals.python.price， 书写代码：animals.python.price!0 当且仅当 animals.python 永远存在， 而仅仅最后一个子变量 price 可能不存在时是正确的 (这种情况下我们假设价格是 0)。 
如果 animals 或 python 不存在， 那么模板处理过程将会以"未定义的变量"错误而停止。为了防止这种情况的发生， 可以如下这样来编写代码 (animals.python.price)!0。 这种情况就是说 animals 或 python 不存在时， 
表达式的结果是 0。对于 ?? 也是同样用来的处理这种逻辑的; 将 animals.python.price?? 对比 (animals.python.price)??来看

<#--字符转义-->
 如果想要打印 ${ 或 #{， 就要使用下面所说的原生字符串，或者进行转义。就像 "foo $\{bar}"中的 {。
 原生字符串是一种特殊的字符串。在原生字符串中， 反斜杠和 ${ 没有特殊含义， 它们被视为普通的字符。为了表明字符串是原生字符串， 在开始的引号或单引号之前放置字母r
使用scape指令
<#escape x as x?html>

  <p>Title: ${book.title}</p>
  <p>Description: <#noescape>${book.description}</#noescape></p>
  <h2>Comments:</h2>
  <#list comments as comment>
    <div class="comment">
      ${comment}
    </div>
  </#list>
  ...
</#escape><#-- 值域-->
值域也是序列，但它们由指定包含的数字范围所创建， 而不需指定序列中每一项。比如： 0..<m，这里假定 m 变量的值是5，那么这个序列就包含 [0, 1, 2, 3, 4]。值域的主要作用有：使用 <#list...> 来迭代一定范围内的数字，序列切分 和 字符串切分。

start..end： 包含结尾的值域。比如 1..4 就是 [1, 2, 3, 4]， 而 4..1 就是 [4, 3, 2, 1]。当心一点， 包含结尾的值域不会是一个空序列，所以 0..length-1 就是 错误的，因为当长度是 0 时， 序列就成了 [0, -1]。

start..<end 或 start..!end： 不包含结尾的值域。比如 1..<4 就是 [1, 2, 3]，4..<1 就是 [4, 3, 2], 而 1..<1 表示 []。请注意最后一个示例； 结果可以是空序列，和 ..< 和 ..! 没有区别; 最后这种形式在应用程序中使用了 < 字符而引发问题(如HTML编辑器等)。

start..*length： 限定长度的值域，比如 10..*4 就是 [10, 11, 12, 13]，10..*-4 就是 [10, 9, 8, 7]，而 10..*0 表示 []。当这些值域被用来切分时， 如果切分后的序列或者字符串结尾在指定值域长度之前，则切分不会有问题；请参考 序列切分 来获取更多信息。

注意值域表达式本身并没有方括号，比如这样编写代码 <#assign myRange = 0..<x>， 而不是 <#assign myRange = [0..<x]>。 后者会创建一个包含值域的序列。方括号是切分语法的一部分，就像 seq[myRange]。

<#-- 插值-->
用户所犯的一个常见错误是将插值放在了不需要/不应该使用的地方。 插值 仅 在 文本 区 中有效。(比如， <h1>Hello ${name}!</h1>) 还有在字符串值中 (比如， <#include "/footer/${company}.html">)。 典型的 错误 使用是 <#if ${big}>...</#if>， 这会导致语法错误。
简单写为 <#if big>...</#if>即可。 而且， <#if "${big}">...</#if> 也是 错误的， 因为它将参数值转换为字符串，但是 if 指令只接受布尔值， 那么这将导致运行时错误。

<#--字符串切分 -->
可以按照 切分序列 (请参看)的相同方式来切分字符串，这就是使用字符来代替序列。不同的是降序域不允许进行字符串切分，如果变量的值既是字符串又是序列(多类型值)， 那么切分将会对序列进行，而不是字符串。，

<#--序列切分 -->
结果序列会包含原序列 (seq)中的项， 而且索引在值域中，此外，切分后序列中的项会和值域的顺序相同。
值域中的数字必须是序列可使用的合法索引， 否则模板的处理将会终止并报错。像上面的示例那样， seq[-1..0] 就会出错， 而 seq[-1] 就是合法的。 seq[1..5] 也不对， 因为 seq[5] 是非法的。 (请注意，尽管100已经越界，但是 seq[100..<100] 或 seq[100..*0] 是合法的，因为那些值域都是空。
限制长度的值域 (start..*length) 和无右边界值域 (start..) 适用于切分后序列的长度。它们会切分可用项中尽可能多的部分

<#--定义宏 ，person是参数名称，greet是宏的名称-->
<#macro greet person>
  <font size="+2">Hello ${person}!</font>
</#macro>

<#nested> 指令执行位于开始和结束标记指令之间的模板代码段
<#macro border>
  <table border=4 cellspacing=0 cellpadding=4><tr><td>
    <#nested>
  </tr></td></table>
</#macro>
<@border>The bordered text</@border>
输出：
<table border=4 cellspacing=0 cellpadding=4><tr><td>
    The bordered text
  </td></tr></table>
<#--使用宏时必须给出在宏中定义所有参数的值 -->
<@greet person="Fred"/> and <@greet person="Batman"/>
<#-- -->
<#-- -->
<#-- -->
<#-- -->
<#-- -->
<#-- -->
<#-- -->
<#-- -->
