<h1>Setting values to the Student Objets</h1>

<jsp:useBean id="student" class="in.ineuron.beam.Srudent"/>

<jsp:setProperty property="sid" name="student" value="10"/>
<jsp:setProperty property="sname" name="student" value="sachin"/>
<jsp:setProperty property="saddress" name="student" value="MI"/>
<jsp:setProperty property="sage" name="student" value="49"/>

<%= student %>