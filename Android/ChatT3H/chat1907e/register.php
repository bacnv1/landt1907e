<?php
	include 'connection.php';

	$email = $_POST['email'];
	$password = $_POST['password'];
	$name = $_POST['name'];

	if (!$email || !$password || !$name) {
		header('HTTP/1.1 401 register fail');
		return;
	}

	$sql = "INSERT INTO `user`(`email`, `password`, `name`) VALUES ('$email','$password','$name')";
	$query = $conn -> query($sql);

	if ($query) {
		header('HTTP/1.1 200 register success');
	} else {
		header('HTTP/1.1 401 register fail');
	}
?>