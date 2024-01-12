<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;

class HomeController extends Controller
{
    public function index(){
        $title = 'Hoc Lap Trinh Laravel';
        $content = 'View trong laravel';

        return view('home', compact('title', 'content'));
        // return view('home',)->with(['title' => $title, 'content' => $content]); giong compact
        // return View::make('home', compact('title', 'content'));
        /*
            $contentView =view('home');
            echo $contentView; // thi van dung duoc
            cach de chuyen $contentView thanh chuoi html tho
            $contentView = $contentView->reder();
            dd($contentView);

        */
    }

    public function getNews($id=null){
        return 'get news '.$id;
    }
}
