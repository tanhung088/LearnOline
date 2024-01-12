import React from 'react' // nạp thư viện react
import ReactDOM from 'react-dom' // nạp thư viện react-dom

// Tạo component App
function App() {
    return (
        <div>
            <h1>Xin chào anh em F8!</h1>
            <h2>tan hung</h2>
        </div>
    )
}

// Render component App vào #root element
ReactDOM.render(<App />, document.getElementById('root'))
//with version 18
// const root = ReactDOM.createRoot(document.getElementById('root'))
// va import la import ReactDOM from 'react-dom/client' // nạp thư viện react-dom
// root.render(<App />)

