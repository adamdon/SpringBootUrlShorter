

export default function Home()
{
    const [test, setTest] = useState("here");
    const [urlInput, setUrlInput] = useState("");
    const [disabled, setDisabled] = useState(false);





    async function confirmUrlOnClick()
    {
        console.log("Click!")

    }




    return(
        <div className={'alert alert-primary'}>
            <h1>Spring Boot Url Shorter</h1>
            <p>Enter a URL you would like to make smaller</p>

            <div className="input-group my-3">
                <span className="input-group-text bg-primary text-white" >URL: </span>
                <input value={urlInput} onChange={e => setUrlInput(e.target.value)} onKeyDown={async e => {if(e.key === "Enter") await confirmUrlOnClick()}} disabled={disabled} placeholder='Enter Address' type="url" aria-label="url" id="url" className="form-control"/>
                <button onClick={confirmUrlOnClick} disabled={disabled} className="btn btn-primary" type="button" id="submit">Shorten</button>
            </div>
            <div className="alert alert-secondary" role="alert">
                Click here to copy!
            </div>

        </div>
    );
}


