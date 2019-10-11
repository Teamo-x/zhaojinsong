<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'employeeBehaviorSpecification.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <script>
 function back() {
  location.href = "register.jsp";

 }
</script>

  <body>
     <center>
     
     <h1>公司员工规范</h1>
     </center>
     <p>一、在公司内，应遵守公司各项规章制度，服从上级指挥。</p>
       <p>二、上下班时，必须谨记打考勤卡，不得代打。</p>
         <p>三、严格遵守工作时间，做到不迟到，不早退。下班时间到后，必须整理好物品下班。</p>
           <p>四、工作期间应认真工作，不允许串岗聊天和在工作区内大声喧哗，不得妨碍他人开展业务工作，不得擅自离开工作岗位，不可阅读与工作业务无关的书报杂志。</p>
             <p>五、工作时，不打非业务性电话，接非业务性电话时应尽量缩短时间。</p>
               <p>六、必须履行对公司机密、业务上的重要信息的保密义务，不得将公司业务及营销信息泄露给他人。不打听，不传播与本人无关的，不该打听不该传播的事项。</p>   
                 <p>七、不得将公司资料、设备、器材用作私用，如需携带外出须得到批准。</p>
                   <p>八、与工作无关的私物不得随意带入公司，工作场地非经许可不得进行各类娱乐活动。</p>
                     <p>　九、员工个人所借用的工具、物品必须妥善保管，不得随意拆卸或改装。若出现故障须及时向上级申报。</p>
                       <p>十、无操作资格者不得操作公司的有关设备、器具等。</p>
                         <p>十一、客人来访原则上应有预约，并在指定场所接待。非工作人员不经许可不得进入工作场所。</p>
                           <p>十二、公司员工间及对公司外的人员，必须礼貌待人，文明用语，不讲粗话、脏话。同事之间要和睦相处，互相团结、帮助。</p>
                             <p>　十三、公司员工上班一定要佩戴胸卡，如有遗失应尽快申请补办。</p>
                             <p>十四、员工着装应以反映良好的精神面貌为原则。男职员着装要清洁整齐，禁止穿拖鞋、背心、田径裤。女职员穿着要大方得体，不浓妆艳抹，不准单穿吊带衫、凉拖鞋。</p>
                               <p>　十五、随时注意保持周边环境卫生清洁，不随地吐痰、不乱扔纸屑烟蒂、不乱涂乱画。雨具、雨鞋一律放置在规定存放处。</p>
                                 <p>十六、除在指定场所、时间外，不允许饮食、吸烟。</p>
                                   <p>十七、节约用水、用电、办公用品。安全用电，爱护灯管、插座、开关等电路设施。不准私自拆除、搬移和乱拉线路。若有损坏，须通知总务处进行更换、修理。</p>
                                     <p>十八、必须遵守用火规则（下班前关闭煤气、清理烟缸、切断电源）</p>
                                       <p>十九、所有设备、器具等必须保持可正常安全运作状态。</p>
                                         <p>二十、发生传染病立即报告</p>
                                         
                                               
             <input type="button" value="返回" onclick="back()" />
     </center>
  </body>
</html>
