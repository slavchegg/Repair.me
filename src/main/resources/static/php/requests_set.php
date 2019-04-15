<?php
include "headers.inc.php";
$output = ["status" => 0];
session_start();
  $conn = new mysqli("localhost", "plants", "plants", "plants");
  if (!($conn->connect_errno)) {
      $_POST = json_decode(file_get_contents("php://input"), true);
      $mechanic = $conn->real_escape_string($_POST["mechanic"]);
      $content = $conn->real_escape_string($_POST["content"]);
      $user = $conn->real_escape_string($_POST["user"]);
      $q = $conn->query("insert into requests(mechanic, content, user) values('" . $mechanic .
      "', '" . $content . "', '" . $user . "')");
    }
    $output["status"] = ($q) ? 1 : 0;
    $conn->close();

echo json_encode($output, JSON_UNESCAPED_UNICODE);