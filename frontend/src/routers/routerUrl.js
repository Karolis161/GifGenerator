import React, {
	Component
} from "react";
import {
	Routes,
	Route,
	Link
} from 'react-router-dom';

import Home from "../components/Home";
import ViewGifs from "../components/ViewGifs";
import GenerateGifs from "../components/GenerateGifs";

export default class RouterURL extends Component {
  render() {
  return (
<div>
	<Link to="/" className="btn btn-primary">Home</Link> &nbsp;&nbsp;&nbsp;
	<Link to="/viewGifs" className="btn btn-primary">View Gifs</Link> &nbsp;&nbsp;&nbsp;
	<Link to="/generateGifs" className="btn btn-primary">Generate Gifs</Link>
	<Routes>
		<Route path="/" element={<Home />} />
		<Route path="/viewGifs" element={<ViewGifs />} />
		<Route path="/generateGifs" element={<GenerateGifs />} />
	</Routes>
</div>
  );
  }
}