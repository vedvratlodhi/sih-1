<%@include file="include/header.jsp"%>
<%@include file="include/sidebar.jsp"%>





<script>

function getState(countryId) {
	$('#stateId').find('option').remove().end().append('<option value="">Select State</option>').val('');
	
	$.ajax({
		type : "POST",
		url : "ajax/getStates?id="+countryId,
		

	}).done(
			function(stateList) {
			
				var opt = '<option value="">Select State</option>';
				for (i in stateList) {
					opt += '<option value="'+stateList[i].id+'">'
							+ stateList[i].name + '</option>';
				}
				$('#stateId').html(opt);
				  $("#stateId").selectpicker("refresh");
			});
}


function getCity(stateId) {
	$('#cityId').find('option').remove().end().append('<option value="">Select City</option>').val('');
	
	$.ajax({
		type : "POST",
		url : "ajax/getCities?id="+stateId,
		

	}).done(
			function(cityList) {
			
				var opt = '<option value="">Select City</option>';
				for (i in cityList) {
					opt += '<option value="'+cityList[i].id+'">'
							+ cityList[i].name + '</option>';
				}
				$('#cityId').html(opt);
				 $("#cityId").selectpicker("refresh");
			});
}
</script>
</script>
<section class="content">
	<div class="container-fluid">
		<div class="block-header">
		<div class="body">
					<c:if test="${not empty error}">
						<script>
								window.onload = function() {
									/* callAlert("${error}"); */
									callErrorAlert("Error!!", "${error}")
								}
							</script>
					</c:if>
					<c:if test="${not empty success}">
						<script>
								window.onload = function() {
									callImageAlert("Success", "${success}");
								}
							</script>
					</c:if>
				<ol class="breadcrumb">
					<li><a href="/creathon">Home</a></li>
					<li><a href="javascript:void(0);">Masters</a></li>
					<li class="active">Add Agency</li>
				</ol>
			</div>
			<!-- <h2>ADD AGENCY</h2> -->
		</div>
		<!-- Basic Validation -->
		<div class="row clearfix">
			<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
				<div class="card">
					<div class="header">
						<h2>ADD AGENCY DETAILS</h2>
					</div>
					<div class="body">
						<form:form id="form_validation" method="POST" action="saveAgency" modelAttribute="agency" enctype="multipart/form-data">
						
							<div class="col-md-6">
								<div class="form-group form-float">
									<div class="form-line">
										<form:input type="text" class="form-control" path="name" name="agency_name" required="true"/> <label class="form-label">Agency
											Name</label>
									</div>
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group form-float">
									<div class="form-line">
										<form:input type="email" class="form-control" path="email" name="email" required="true"/>
										<label class="form-label">Email</label>
									</div>
								</div>
							</div>
							<div class="col-sm-4">
							<label class="form-label">Select Country</label>
								<form:select class="form-control show-tick" path="addressId.country.id" onchange="getState(this.value)">
									<option value="">-- Country --</option>
									<c:forEach items="${countryList}" var="cl">
									<option value="${cl.id}">${cl.name}</option>
										</c:forEach>
								</form:select>
							</div>
							<div class="col-sm-4">
							<label class="form-label">Select State</label>
								<form:select class="form-control show-tick" onchange="getCity(this.value)" id="stateId" path="addressId.state.id">
									<option value="">-- State --</option>
									
									<c:forEach items="${stateList}" var="sl">
													<option value="${sl.id}">${sl.name}</option>
										</c:forEach>
								</form:select>
							</div>
							<div class="col-sm-4">
							<label class="form-label">Select City</label>
								<form:select class="form-control show-tick" id="cityId" path="addressId.city.id">
									<c:forEach items="${stateList}" var="sl">
													<option value="${sl.id}">${sl.name}</option>
										</c:forEach>
								</form:select>
							</div>
							<div class="col-md-6">
								<div class="form-group form-float">
									<div class="form-line">
										<form:input type="text" path="addressId.landmark" class="form-control" name="landmark"
											required="true"/> <label class="form-label">Landmark</label>
									</div>
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group form-float">
									<div class="form-line">
										<form:input type="text" path="addressId.street" class="form-control" name="street" required="true"/>
										<label class="form-label">Street</label>
									</div>
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group form-float">
									<div class="form-line">
										<form:input type="text" path="addressId.pincode" class="form-control" name="pincode"
											required="true"/> <label class="form-label">Pincode</label>
									</div>
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group form-float">
									<div class="form-line">
										<form:input type="text" path="addressId.buildingNo" class="form-control" name="building_no"
											required="true"/> <label class="form-label">Flat no /
											Building name</label>
									</div>
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group form-float">
									<div class="form-line">
										<form:input type="text" path="representativeName" class="form-control"
											name="representative_name" required="true"/> <label
											class="form-label">Representative Name</label>
									</div>
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group form-float">
									<div class="form-line">
										<form:input type="text" path="representativeContactNo" class="form-control" name="rep_cont_no"
											required="true"/> <label class="form-label">Representative
											contact no</label>
									</div>
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group form-float">
									<div class="form-line">
										<form:input type="email" path="representativeEmail" class="form-control" name="rep_email"
											required="true"/> <label class="form-label">Representative
											email</label>
									</div>
								</div>
							</div>
						
							<div class="col-md-6">
								<div class="form-group form-float">
									<label class="form-label">Agency profile pic</label>
									<div class="form-line">
										<form:input type="file" class="form-control" name="agency_profile" path="agencyPhoto"
											required="true"/>

									</div>
								</div>
							</div>
							<div class="col-md-6">
							<label class="form-label">Select Type</label>
								<form:select class="form-control show-tick" path="type">
									<option value="">-- Type --</option>
									<option value="w">Without Location</option>
									<option value="wo">With Location</option>
								</form:select>
							</div>
							<button class="btn btn-primary waves-effect" type="submit">SUBMIT</button>
						</form:form>
					</div>
				</div>
			</div>
		</div>
		<!-- #END# Basic Validation -->

	</div>
</section>
<%@include file="include/footer.jsp"%>