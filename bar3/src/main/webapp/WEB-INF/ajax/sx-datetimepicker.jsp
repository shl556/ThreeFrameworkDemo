
<%@ page contentType="text/html; charset=UTF-8" language="java" errorPage="" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<!DOCTYPE html>
<html>
<head>
	<meta name="author" content="Yeeku.H.Lee(CrazyIt.org)" />
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>使用sx:datetimepicker生成日期选择框</title>
	<sx:head/>
</head>
<body>
<!-- 
datetimepicker支持如下格式符：
d：指定处于当月的第几日
D：指定处于当年的第几天
M：代表月份，使用1-2个M代表数字月份，使用3个M代表月份缩写，使用4个M代表月份全屏
y：代表年份，可以使用yy或者yyyy形式
h：代表12小时制
H：代表24小时制
m:代表分钟
s:代表秒钟
可以指定如下常用属性：
displayFormat：指定日期的显示格式，如dd/MM/yyyy作为日期格式
displayWeeks：指定日历是否显示星期数
endDate：指定日期集的最后可用日期
formatLength：指定日期显示的格式，支持long、short、medium和full。
language：指定日期显示的Locale
startDate：指定日期集的开始可用日期。
toggleDuration:指定日期选择框出现隐藏的切换时间
toggleType：指定日期选择框出现隐藏的方式，可以选择plain、wipe、explode和fade四个值
type：指定日期选择框的类型，支持的值有date和time，代表日期选择框和时间选择框
value：指定当前日期时间，可以使用today来代表今天
weekStartsOn：指定日期选择框中哪一天才是一周的第一天，周日是0，周六是6.
 -->
<h3>使用使用sx:datetimepicker生成日期选择框</h3>
<s:form theme="simple">
	日期选择部件，指定toggleType属性,且指定value="today"<br>
	<sx:datetimepicker
		name="date1" 
		label="购买日期" 
		toggleType="explode" 
		value="today"/><hr />
	日期选择部件，指定了format属性<br />
	<sx:datetimepicker
		name="date2"
		label="购买日期"
		displayFormat="yyyy年MM月dd日"/><hr />
	日期选择部件，指定了weekStartsOn属性<br />
	<sx:datetimepicker
		name="date3" 
		label="购买日期"
		displayFormat="yyyy年MM月dd日" 
		weekStartsOn="2"/><hr />
	时间选择部件<br />
	<sx:datetimepicker 
		name="start"
		label="选择出发时间"
		type="time"
		value="13:00"/>
</s:form>
</body>
</html>