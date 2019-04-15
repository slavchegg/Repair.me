<?php
include "headers.inc.php";
$output = [];
$conn = new mysqli("localhost", "plants", "plants", "plants");
if (!($conn->connect_errno)) {
  $name = $conn->real_escape_string($_GET["name"]);
  $q = $conn->query("select * from requests where mechanic = " . $name);
  while ($row = $q->fetch_assoc()) {
    $output[] = ["id" => $row["id"], "user" => $row["user"], "content" => $row["content"];
  }
  $q->close();
  $conn->close();
}
echo json_encode($output, JSON_UNESCAPED_UNICODE);