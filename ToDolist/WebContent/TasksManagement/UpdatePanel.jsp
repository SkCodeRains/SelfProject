
<div class="EditUpdate">

	<div class="EditUpdateChild">
		<%
		String Text = request.getParameter("data");
		String id = request.getParameter("id");System.out.print(id);	
		
		%>

		<textarea name="styled-textarea" id="styled" class="<%=id%>"><%=Text%></textarea>
		<br>
		<button class="UpdateP  button"
			onclick="UpdateAjax('<%=id%>','<%=request.getParameter("divId")%>')">Update</button>
		<button class="CancelUpdate button" onclick="removeDiv()">Cancel</button>


	</div>

</div>