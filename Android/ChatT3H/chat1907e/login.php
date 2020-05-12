<?php
	include 'connection.php';
	$email = $_POST['email'];
	$password = $_POST['password'];

	$sql = "select * from user where email = '$email' and password = '$password'";
	$query = $conn -> query($sql);
	$row = $query -> fetch_array();
	if ($row) {
		$data = array(
			"email" => $row['email'],
			"password" => $row['password'],
			"name" => $row['name']
		);
		echo json_encode($data);
	} else {
		header('HTTP/1.1 401 login fail');
	}
?>