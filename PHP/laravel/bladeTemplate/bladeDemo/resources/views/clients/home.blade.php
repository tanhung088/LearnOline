
@extends('layouts.client')
@section('title')
    {{ $title }}
@endsection
@section('sidebar')
    @parent
    <h3>Home Sidebar</h3>
@endsection

@section('content')
    <h1>Trang Chu</h1>
    {{-- @datetime da duoc dinh nghia trong provider --}}
    @datetime("2022-10-11 10:00:30")

    {{-- @disk la cau lenh re nhanh da duoc dinh nghia trong provider --}}
    @disk('local')
    <p>Moi truong local</p>
    @elsedisk('production')
    <p>Moi trong production</p>
    @elsedisk('test')
    <p>Moi truong test</p>
    @enddisk

@endsection













{{-- @section('css')
    <style>
        header {
            color: brown;
        }
    </style>
@endsection --}}

{{-- @section('js')
    <script>
        document.querySelector('.show').onclick = function(){
            alert('Thanh Cong');
            // <div class="alert alert-primary" role="alert">
            //     <a href="#" class="alert-link">an example link</a>. Give it a click if you like.
            // </div>
        }
    </script>
@endsection --}}
