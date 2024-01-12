<h1 style="text-align: center"> HA_Unicode Laravel </h1>
<?PHP
    // echo date('Y-m-d H:i:s');
    // echo "<br>";
    // echo "Lay ra cach thuc APP_ENV : ";
    // echo env('APP_ENV');
    // // Hoac bang cach khac la:
    // echo '<br>';
    // echo config('app.env');
    // echo "<br>";
    // if(env('APP_ENV') == "production"){
    //     echo "Call API with live";
    // }else{
    //     echo "Call API with sanbox";
    // }
    /*
        <a href="<?php echo route('admin.show-form') ?>">show form with name</a> <br>
    <a href="<?php echo route('admin.products.add') ?>">show add with name</a> <br>
    <a href="<?php echo route('admin.home', ['id'=> 1, 'slug'=>'tanhung']) ?>">show add with name</a>
    */
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
    <h1>Header -- Header</h1>
    <?php echo $title ?>
    <h1>Body -- Body</h1>
    <?php echo $content ?>
    <h1>Footer -- Header</h1>
</body>
</html>
