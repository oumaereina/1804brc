$(document).ready(function() {
	$("#demo").fadeOut(2000);
	$("#test").hide();
	//	�������ӷ�����
	$("#Submit").click(function() {
		var username = $("#username").val();
		var password = $("#password").val();
		var level = $("#level").val();
		if (username == "") {
			alert("�û�������Ϊ�գ���");
			return false;
		}
		if (password == "") {
			alert("���벻��Ϊ�գ���");
			return false;
		}
		if (level == "") {
			alert("�û�Ȩ�޲���Ϊ�գ���");
			return false;
		}
	});
	$("#cs").click(function() {
		$("#username").val("");
		$("#password").val("");
		$("#level").val("");

	});
	$("#regitUser").click(function() {
		var username = $("#regitusername").val();
		var password = $("#regitpassword").val();
		var age = $("#regitage").val();
		var tel = $("#regittel").val();

		if (username == "") {
			alert("�������û�������");

			$("#regitusername").css("background", "#B7E1FA");
			$("INPUT").keypress(function() {
				$("#regitusername").css("background", "#FFFFFF");
			});
			return false;
		}
		if (password == "") {
			alert("���벻��Ϊ�գ���");
			$("#regitpassword").css("background", "#B7E1FA");
			$("INPUT").keypress(function() {
				$("#regitpassword").css("background", "#FFFFFF");
			});
			return false;
		}
		if (age == "") {
			alert("���䲻��Ϊ�գ���");
			return false;
		}
		if (tel == "") {
			alert("�绰����Ϊ�գ���");
			return false;
		}

		if (age.search("^-?\\d+$") != 0) {
			alert("��������ȷ�������ʽ����");
			$("#regitage").val("");
			$("#regitage").css("background", "#B7E1FA");
			$("INPUT").keypress(function() {
				$("#regitage").css("background", "#FFFFFF");
			});
			return false;
		}
		if (tel.search("^-?\\d+$") != 0) {
			alert("��������ȷ�ĵ绰��ʽ����");
			$("#regittel").val("");
			$("#regittel").css("background", "#B7E1FA");
			$("INPUT").keypress(function() {
				$("#regittel").css("background", "#FFFFFF");
			});
			return false;
		}

	});
	$("#addContract").click(function() {
		var username = $("#username").val();
		var cname = $("#cname").val();
		var cnature = $("#cnature").val();
		var cagreement = $("#cagreement").val();
		var ctime=$("#dateDemo").val();
		var cend = $("#cend").val();
		if (username == "") {
			alert("��������Ϊ�գ���");
			$("#username").css("background", "#B7E1FA");
			$("INPUT").keypress(function() {
				$("#username").css("background", "#FFFFFF");
			});
			return false;
		}
		if (cend == "") {
			alert("��Ч�ڲ���Ϊ�գ���");
			$("#cend").css("background", "#B7E1FA");
			$("INPUT").keypress(function() {
				$("#cend").css("background", "#FFFFFF");
			});
			return false;
		}
			if (ctime == "") {
			alert("��ѡ��ǩԼʱ��");
			$("#dateDemo").css("background", "#B7E1FA");
			$("INPUT").keypress(function() {
				$("#dateDemo").css("background", "#FFFFFF");
			});
			return false;
		}

		if (cname == "") {
			alert("��ͬ���Ʋ���Ϊ�գ���");
			$("#cname").css("background", "#B7E1FA");
			$("INPUT").keypress(function() {
				$("#cname").css("background", "#FFFFFF");
			});
			return false;
		}
		if (cnature == "") {
			alert("��ͬ���ʲ���Ϊ�գ���");
			$("#cnature").css("background", "#B7E1FA");
			$("INPUT").keypress(function() {
				$("#cnature").css("background", "#FFFFFF");
			});
			return false;
		}
		if (cagreement == "") {
			alert("��ͬ���ݲ���Ϊ�գ���");
			$("#cagreement").css("background", "#B7E1FA");
			$("INPUT").keypress(function() {
				$("#cagreement").css("background", "#FFFFFF");
			});
			return false;
		}
		if (cend.search("^-?\\d+$") != 0) {
			alert("��������ȷ�����ָ�ʽ����");
			$("#cend").val("");
			$("#cend").css("background", "#B7E1FA");
			$("INPUT").keypress(function() {
				$("#cend").css("background", "#FFFFFF");
			});
			return false;
		}

	});

	$("#addnotice").click(function() {
		var nname = $("#nname").val();
		var ncontent = $("#ncontent").val();

		if (nname == "") {
			alert("�������Ʋ���Ϊ�գ���");
			$("#nname").css("background", "#B7E1FA");
			$("INPUT").keypress(function() {
				$("#nname").css("background", "#FFFFFF");
			});
			return false;
		}

		if (ncontent == "") {
			alert("�������ݲ���Ϊ�գ���");
			$("#ncontent").css("background", "#B7E1FA");
			$("INPUT").keypress(function() {
				$("#ncontent").css("background", "#FFFFFF");
			});
			return false;
		}

	});

	$("#addsalary").click(function() {
		var username = $("#username").val();
		var bwage = $("#bwage").val();
		var housefund = $("#housefund").val();
		var pension = $("#pension").val();
		var health = $("#health").val();
		var unemployment = $("#unemployment").val();
		var reimbursement = $("#reimbursement").val();
		var paword = $("#paword").val();

		if (username == "") {
			alert("Ա����������Ϊ�գ���");
			$("#username").css("background", "#B7E1FA");
			$("SELECT").keypress(function() {
				$("#username").css("background", "#FFFFFF");
			});
			return false;
		}

		if (bwage == "") {
			alert("�������ʲ���Ϊ�գ���");
			$("#bwage").css("background", "#B7E1FA");
			$("INPUT").keypress(function() {
				$("#bwage").css("background", "#FFFFFF");
			});
			return false;
		}

		if (housefund == "") {
			alert("ס����������Ϊ�գ���");
			$("#housefund").css("background", "#B7E1FA");
			$("INPUT").keypress(function() {
				$("#housefund").css("background", "#FFFFFF");
			});
			return false;
		}

		if (pension == "") {
			alert("���ϱ��ղ���Ϊ�գ���");
			$("#pension").css("background", "#B7E1FA");
			$("INPUT").keypress(function() {
				$("#pension").css("background", "#FFFFFF");
			});
			return false;
		}

		if (health == "") {
			alert("ҽ�Ʊ��ղ���Ϊ�գ���");
			$("#health").css("background", "#B7E1FA");
			$("INPUT").keypress(function() {
				$("#health").css("background", "#FFFFFF");
			});
			return false;
		}

		if (unemployment == "") {
			alert("ʧҵ���ղ���Ϊ�գ���");
			$("#unemployment").css("background", "#B7E1FA");
			$("INPUT").keypress(function() {
				$("#unemployment").css("background", "#FFFFFF");
			});
			return false;
		}

		if (reimbursement == "") {
			alert("��������Ϊ��,����0����");
			$("#reimbursement").css("background", "#B7E1FA");
			$("INPUT").keypress(function() {
				$("#reimbursement").css("background", "#FFFFFF");
			});
			return false;
		}

		if (paword == "") {
			alert("ҵ��������Ϊ�գ���");
			$("#paword").css("background", "#B7E1FA");
			$("INPUT").keypress(function() {
				$("#paword").css("background", "#FFFFFF");
			});
			return false;
		}
		if (bwage.search("^-?\\d+$") != 0) {
			alert("������������ʽ����");
			$("#bwage").val("");
			$("#bwage").css("background", "#B7E1FA");
			$("INPUT").keypress(function() {
				$("#bwage").css("background", "#FFFFFF");
			});
			return false;
		}
		if (housefund.search("^-?\\d+$") != 0) {
			alert("������������ʽ����");
			$("#housefund").val("");
			$("#housefund").css("background", "#B7E1FA");
			$("INPUT").keypress(function() {
				$("#housefund").css("background", "#FFFFFF");
			});
			return false;
		}
		if (pension.search("^-?\\d+$") != 0) {
			alert("������������ʽ����");
			$("#pension").val("");
			$("#pension").css("background", "#B7E1FA");
			$("INPUT").keypress(function() {
				$("#pension").css("background", "#FFFFFF");
			});
			return false;
		}
		if (health.search("^-?\\d+$") != 0) {
			alert("������������ʽ����");
			$("#health").val("");
			$("#health").css("background", "#B7E1FA");
			$("INPUT").keypress(function() {
				$("#health").css("background", "#FFFFFF");
			});
			return false;
		}
		if (unemployment.search("^-?\\d+$") != 0) {
			alert("������������ʽ����");
			$("#unemployment").val("");
			$("#unemployment").css("background", "#B7E1FA");
			$("INPUT").keypress(function() {
				$("#unemployment").css("background", "#FFFFFF");
			});
			return false;
		}
		if (reimbursement.search("^-?\\d+$") != 0) {
			alert("������������ʽ����");
			$("#reimbursement").val("");
			$("#reimbursement").css("background", "#B7E1FA");
			$("INPUT").keypress(function() {
				$("#reimbursement").css("background", "#FFFFFF");
			});
			return false;
		}
		if (paword.search("^-?\\d+$") != 0) {
			alert("������������ʽ����");
			$("#paword").val("");
			$("#paword").css("background", "#B7E1FA");
			$("INPUT").keypress(function() {
				$("#paword").css("background", "#FFFFFF");
			});
			return false;
		}

	});

	$("#addrec").click(function() {
		var rname = $("#rname").val();
		var department = $("#department").val();
		var rers = $("#rers").val();
		var dateDemo = $("#dateDemo").val();
		var dateDemo1 = $("#dateDemo1").val();
		var content = $("#content").val();

		if (rname == "") {
			alert("����д��Ƹ���ƣ���");
			$("#rname").css("background", "#B7E1FA");
			$("INPUT").keypress(function() {
				$("#rname").css("background", "#FFFFFF");
			});
			return false;
		}

		if (department == "") {
			alert("����д�ʺϵ���Ƹ���ţ���");
			$("#department").css("background", "#B7E1FA");
			$("SELECT").keypress(function() {
				$("#department").css("background", "#FFFFFF");
			});
			return false;
		}
		if (rers == "") {
			alert("����д����Ƹ����������");
			$("#rers").css("background", "#B7E1FA");
			$("INPUT").keypress(function() {
				$("#rers").css("background", "#FFFFFF");
			});
			return false;
		}

		if (dateDemo == "") {
			alert("����д��Ƹ��ʼʱ�䣡��");
			$("#dateDemo").css("background", "#B7E1FA");
			$("INPUT").keypress(function() {
				$("#dateDemo").css("background", "#FFFFFF");
			});
			return false;
		}
		if (dateDemo1 == "") {
			alert("����д��Ƹ����ʱ�䣡��");
			$("#dateDemo1").css("background", "#B7E1FA");
			$("INPUT").keypress(function() {
				$("#dateDemo1").css("background", "#FFFFFF");
			});
			return false;
		}

		if (content == "") {
			alert("����д��Ƹ���ݣ���");
			$("#content").css("background", "#B7E1FA");
			$("INPUT").keypress(function() {
				$("#content").css("background", "#FFFFFF");
			});
			return false;
		}
		if (rers.search("^-?\\d+$") != 0) {
			alert("������������ʽ����");
			$("#rers").val("");
			$("#rers").css("background", "#B7E1FA");
			$("INPUT").keypress(function() {
				$("#rers").css("background", "#FFFFFF");
			});
			return false;
		}

	});

	$("#addcan").click(function() {
		var caname = $("#caname").val();
		var department = $("#department").val();
		var position = $("#position").val();
		var catel = $("#catel").val();
		var cainfo = $("#cainfo").val();

		if (caname == "") {
			alert("����дӦƸ����������");
			$("#caname").css("background", "#B7E1FA");
			$("INPUT").keypress(function() {
				$("#caname").css("background", "#FFFFFF");
			});
			return false;
		}

		if (department == "") {
			alert("����дӦƸ���ţ���");
			$("#department").css("background", "#B7E1FA");
			$("SELECT").keypress(function() {
				$("#department").css("background", "#FFFFFF");
			});
			return false;
		}
		if (position == "") {
			alert("����дӦƸְ�񣡣�");
			$("#position").css("background", "#B7E1FA");
			$("INPUT").keypress(function() {
				$("#position").css("background", "#FFFFFF");
			});
			return false;
		}

		if (catel == "") {
			alert("����дӦƸ����ϵ��ʽ����");
			$("#catel").css("background", "#B7E1FA");
			$("INPUT").keypress(function() {
				$("#catel").css("background", "#FFFFFF");
			});
			return false;
		}
		if (cainfo == "") {
			alert("����дӦƸ����Ϣ����");
			$("#cainfo").css("background", "#B7E1FA");
			$("INPUT").keypress(function() {
				$("#cainfo").css("background", "#FFFFFF");
			});
			return false;
		}
		if (catel.search("^-?\\d+$") != 0) {
			alert("������������ʽ����");
			$("#catel").val("");
			$("#catel").css("background", "#B7E1FA");
			$("INPUT").keypress(function() {
				$("#catel").css("background", "#FFFFFF");
			});
			return false;
		}

	});
	
	$("#addeva").click(function(){
		
		var trafb = $("#trafb").val();
		if(trafb==""){
			alert("�������ѵ����");
			return false;
		}else{
			$("#testtd").val(trafb);
			$("#test").fadeIn();
		}
		
				
	});

});