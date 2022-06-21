import Home from './Home';
import CreateLink from "./CreateLink";
import ViewLink from "./ViewLink";


export default function App()
{
    return (
        <div className="d-flex justify-content-center p-3">
            <div style={{width: 600}}>
                <Home/>
                <CreateLink/>
                <ViewLink/>
            </div>
        </div>
    );
}