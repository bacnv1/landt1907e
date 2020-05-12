<?php
	include 'connection.php';
	$sql = "select a.*, b.name from chat a inner join user b on a.email = b.email";
	$query = $conn -> query($sql);
	$data = array();
	while ($row = $query -> fetch_array()) {
		$data[] = array(
			"name" => $row['name'],
			"content" => $row['content'],
			"pubDate" => $row['pub_date']
		);
	}
	echo json_encode($data);
?>