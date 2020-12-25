import { Route, BrowserRouter as Router, Switch } from "react-router-dom";
import UserTest from "./components/CrudTest/UserTest";

function App() {
    return (
      	<div className="container">
			<Router>
				<Route path="/users/all" exact component={UserTest} />
			</Router>
      	</div>
    )
}

export default App;
