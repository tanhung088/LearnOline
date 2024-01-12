<h1>THEM File vao CHUYEN MUC</h1>
<form method="post" action="<?php echo route('categories.upload') ?>" enctype="multipart/form-data">
    <input type="file" name="photo">
    <input type="hidden" name="_token" value="<?php echo csrf_token(); ?>">
    <button type="submit">Upload</button>
</form>
