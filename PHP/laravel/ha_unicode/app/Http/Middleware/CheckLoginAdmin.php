<?php

namespace App\Http\Middleware;

use Closure;
use Illuminate\Http\Request;
use Illuminate\Routing\Controllers\Middleware;


class CheckLoginAdmin
{
    /**
     * Handle an incoming request.
     *
     * @param  \Illuminate\Http\Request  $request
     * @param  \Closure(\Illuminate\Http\Request): (\Illuminate\Http\Response|\Illuminate\Http\RedirectResponse)  $next
     * @return \Illuminate\Http\Response|\Illuminate\Http\RedirectResponse
     */
    public function handle(Request $request, Closure $next)
    {
        // echo 'Middleware check';
        if(!$this->isLogin()){
            return redirect(route('home'));
        }

        // if($request->is('admin/*') || $request->is('admin') ){ //admin/* kiem tra cac trang con cua admin
        //     echo 'Khu Vuc quan tri';
        // }

        return $next($request);
    }

    public function isLogin(){
        return true;
    }
}
