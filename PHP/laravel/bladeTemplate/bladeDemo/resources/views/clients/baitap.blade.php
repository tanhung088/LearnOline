<h1> HA_Unicode </h1>
{{-- {{ $title }}
{{ $content }} --}}
{!! $title.$content !!}.{{$bodyContent}}

{{-- <hr>
@for($i=1 ; $i<10; $i++)
<p>Phan tu thu : {{$i}}</p>
@endfor --}}


{{-- <hr>
@php
    $index = 1;
@endphp
@while ($index < 10)

    <p>Phan tu thu: {{ $index }}</p>
    @php
        $index++;
    @endphp
@endwhile --}}


<hr>
@foreach ($Arr as $key => $item)
    <p>Phan tu : {{$item}} - {{$key}} </p>
@endforeach

<hr>
@forelse ($Arr as $item)
    <p>Phan tu: {{$item}} </p>
@empty
    <p>Khong co phan tu nao</p>
@endforelse


