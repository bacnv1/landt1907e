<?php
	include 'connection.php';

	$email = $_POST['email'];
	$content = $_POST['content'];
	$pubDate = date("H:i d/m/y");

	if (!$email || !$content) {
		header('HTTP/1.1 401 chat fail');
		return;
	}

	$sql = "INSERT INTO `chat`(`email`, `content`, `pub_date`) VALUES ('$email', '$content', '$pubDate')";
	$query = $conn -> query($sql);

	if ($query) {
		header('HTTP/1.1 200 chat success');
	} else {
		header('HTTP/1.1 401 chat fail');
	}
?>