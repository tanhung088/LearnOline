<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;

class HomeController extends Controller
{
    public $data = [];
    public function index(){
        // $this->data['title'] = '<i>Hoc</i> Lap Trinh';
        // $this->data['content']= '<b>Laravel</b> co ban';
        // $bodyContent = 'Nguyen Tan Hung';
        // $this->data['Arr'] = [
        //     'Item 1',
        //     'Item 2',
        //     'Item 3'
        // ];
        $this->data['title'] = 'My Web Laravel';
        return view('clients.home', $this->data);
    }

    public function product(){
        $this->data['title'] = 'My Web Laravel';
        return view('clients.product', $this->data);
    }

    public function add(){
        $this->data['title'] = 'My Web Laravel';
        return view('clients.add', $this->data);
    }

    public function handlePostAdd(Request $request){
        $this->data['title'] = 'My Web Laravel';
        return $request->all();
    }

    // public function handlePutAdd(Request $request){
    //     $this->data['title'] = 'My Web Laravel';
    //     return $request->all();
    // }

}
