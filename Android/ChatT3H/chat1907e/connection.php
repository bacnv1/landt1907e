<?php
	$host = "localhost";
	$user_name = "root";
	$password = "";
	$db_name = "chat_1907e";
	$conn = mysqli_connect(
		$host,
		$user_name,
		$password,
		$db_name
	);

	mysqli_set_charset($conn, "utf8");
?>