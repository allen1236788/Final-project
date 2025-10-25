<?php
header("Content-Type: application/json");
header("Access-Control-Allow-Origin: *");

$host = "localhost";
$user = "root";
$pass = "";
$dbname = "habitrack";

$conn = new mysqli($host, $user, $pass, $dbname);
if ($conn->connect_error) {
    die(json_encode(["error" => "DB Connection failed: " . $conn->connect_error]));
}

// Get filters from GET
$type       = $_GET['type'] ?? '';
$location   = $_GET['location'] ?? '';
$storey     = $_GET['storey'] ?? '';
$bedroom    = $_GET['bedroom'] ?? '';
$priceRange = $_GET['price_range'] ?? '';
$name       = $_GET['name'] ?? '';
$tandb      = $_GET['tandb'] ?? '';
$size       = $_GET['size'] ?? '';


// Start building query with a base condition for type if provided
$sql = "SELECT * FROM properties WHERE 1=1"; // always true, makes appending filters easier

if ($type !== '') {
    $typeEscaped = $conn->real_escape_string($type);
    $sql .= " AND type = '$typeEscaped'";
}
if ($location !== '') {
    $locationEscaped = $conn->real_escape_string($location);
    $sql .= " AND location = '$locationEscaped'";
}
if ($storey !== '') {
    $storeyEscaped = $conn->real_escape_string($storey);
    $sql .= " AND storey = '$storeyEscaped'";
}
if ($bedroom !== '') {
    $bedroomEscaped = $conn->real_escape_string($bedroom);
    $sql .= " AND bedroom = '$bedroomEscaped'";
}
if ($priceRange !== '') {
    $priceRangeEscaped = $conn->real_escape_string($priceRange);
    $sql .= " AND price_range = '$priceRangeEscaped'";
}
if ($name !== '') {
    $nameEscaped = $conn->real_escape_string($name);
    $sql .= " AND name = '$nameEscaped'";
}
if ($tandb !== '') {
    $tandbEscaped = $conn->real_escape_string($tandb);
    $sql .= " AND tandb = '$tandbEscaped'";
}
if ($size !== '') {
    $sizeEscaped = $conn->real_escape_string($size);
    $sql .= " AND size_range LIKE '%$sizeEscaped%'";
}


$result = $conn->query($sql);

if (!$result) {
    echo json_encode(["error" => "Query error: " . $conn->error]);
    exit;
}

$data = [];
while ($row = $result->fetch_assoc()) {
    $data[] = $row;
}

echo json_encode($data);
$conn->close();
?>
 