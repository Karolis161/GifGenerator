import React from 'react';
import './App.css';
import {
	BrowserRouter as Router,
	Link
} from "react-router-dom";

import RouterURL from './routers/routerUrl';

const App = () => {

return (
<div style={{
             display: 'flex',
             justifyContent: 'center',
             height: '100vh',
             textAlignVertical: "center",
             textAlign: "center",
           }}>

	<Router>
		<div>
			<header className="gifs">
				<h1 id="title">Gif Generator</h1>
			</header>
			<RouterURL />
		</div>
	</Router>
</div>
);
}

export default App;
