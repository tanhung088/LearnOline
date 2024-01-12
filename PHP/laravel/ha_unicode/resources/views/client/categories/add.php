<h1>THEM CHUYEN MUC</h1>
<form method="post" action="<?php echo route('categories.add') ?>">
    <input type="text" name="product_id" placeholder="Enter product id...." value="<?php echo old('product_id'); ?>"><br>
    <input type="text" name="product_name" placeholder="Enter product name...." value="<?php echo old('product_name'); ?>">
    <input type="hidden" name="_token" value="<?php echo csrf_token(); ?>">
    <button type="submit">Submit</button>
</form>
