import { Route, BrowserRouter as Router } from "react-router-dom";
import Navbar from './components/Navbar';
import IndexPage from './pages/IndexPage';
import UserPage from './pages/UserPage';
import BlogPage from './pages/BlogPage';
 
function App() {
    return (
      	<div className="container">
			<Navbar />
			<Router>
				<Route path="/" exact component={IndexPage} />
				<Route path="/users" exact component={UserPage} />
				<Route path="/blog" exact component={BlogPage} />
			</Router>
      	</div>
    )
}

export default App;
