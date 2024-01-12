
@extends('layouts.client')
@section('title')
    {{ $title }}
@endsection
@section('sidebar')
    @parent
    <h3>Product Sidebar</h3>
@endsection

@section('content')
    <h1>Trang Product</h1>

    {{-- Goi componet alert-product-success trong provider da duoc dinh nghia --}}
    <x-alert-product-success></x-alert-product-success>

    {{-- Goi componet theo duong dan thu muc --}}
    {{-- <x-Inputs.button />
    <x-Inputs.link /> --}}
@endsection

@push('script')
    {{-- Them 1 doan ma script moi vao master layout
        Se theo thu tu tu tren xuong

        --}}
    <script>
        console.log('Push lan 1');
    </script>
@endpush

@push('script')
    <script>
        console.log('Push lan 2');
    </script>
@endpush

@prepend('script')
    {{-- Neu muon dua doan script nay len dau tien thi dung prepend --}}
<script>
    console.log('Push lan 3');
</script>
@endprepend






{{-- @section('css')
    <style>
        header {
            color: brown;
        }
    </style>
@endsection

@section('js')
    <script>
        document.querySelector('.show').onclick = function(){
            alert('Thanh Cong');
            // <div class="alert alert-primary" role="alert">
            //     <a href="#" class="alert-link">an example link</a>. Give it a click if you like.
            // </div>
        }
    </script>
@endsection --}}
