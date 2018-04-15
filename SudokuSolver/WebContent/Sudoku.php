
<html>
<head></head>

<body>
    <form action="SudokuServlet" method="POST" id="SudokuChallenge">
<table>
<th>
<tr>
<?php
$m = 1;
while($m<=9){
    echo "<th scope='col'>".$m." Column</th>";
    $m++;
}
?>
</tr>
</th>
    <?php
            for($j=1;$j<=9;$j++){
                ?>
    <tr>
        <?php for($k=1;$k<=9;$k++){ ?>
        <td>
            
        <?php echo "<select id='".$j,$k."'>"; ?>
        <?php
               
        for($i=0;$i<=9;$i++)
        echo "<option value='".$i."'>".$i."</option>";
        ?>
        </td>
            <?php } ?>
    </tr>
    <?php } ?>
    </table>
        <input type="submit" value="Solve it">
    </form>
</body>
</html>