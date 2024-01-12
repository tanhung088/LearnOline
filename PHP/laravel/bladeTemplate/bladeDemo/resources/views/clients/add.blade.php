
@extends('layouts.client')
@section('title')
    {{ $title }}
@endsection
@section('sidebar')
    @parent
    <h3>Product Sidebar</h3>
@endsection

@section('content')
    <h1>Trang Them San Pham</h1>
    <form action="" method="POST">
        <input type="text" name="product_id"><br>
        <input type="text" name="product_name">
        <button type="submit">Submit</button>
        @csrf
        @method('PUT')
    </form>

@endsection
