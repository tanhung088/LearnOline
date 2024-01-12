<?php

namespace App\Providers;

use Illuminate\Support\ServiceProvider;
use Illuminate\Support\Facades\Blade;
use App\View\Components\Alert;
class AppServiceProvider extends ServiceProvider
{
    /**
     * Register any application services.
     *
     * @return void
     */
    public function register()
    {
        //
    }

    /**
     * Bootstrap any application services.
     *
     * @return void
     */

     /*
        Dinh nghia 1 phuong thuc se luon co o tat ca cac trang khi duoc khoi dong
     */

    public function boot()
    {
        /* Dinh nghia datetime */
        Blade::directive('datetime', function ($expression){
            // $expression = trim('\'');
            $expression = trim($expression,'"');
            $dateObject = date_create($expression);
            // dd($expression);
            if(!empty($dateObject)){
                $dateFormat = $dateObject->format('d/m/Y H:i:s');
                return $dateFormat;
            }
            return false;

        });

        /*Dinh nghia 1 caulenh re nhanh */
        Blade::if('disk', function($value){
            if(config('app.env')==$value){
                return true;
            }else{
                return false;
            }
        });

        /*Dinh nghia 1 component alert */
        Blade::component('alert-product-success', Alert::class);
    }
}
