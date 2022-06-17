

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
        <div>
            <h1>Hello home</h1>
            <p>{test}</p>



            <div className="input-group mt-3">
                <span className="input-group-text" >URL: </span>
                <input value={urlInput} onChange={e => setUrlInput(e.target.value)} onKeyDown={async e => {if(e.key === "Enter") await confirmUrlOnClick()}} disabled={disabled} placeholder='Enter Address' type="url" aria-label="url" id="url" className="form-control w-50"/>
                <button onClick={confirmUrlOnClick} disabled={disabled} className="btn btn-outline-dark" type="button" id="submit">Shorten</button>
            </div>


        </div>
    );
}


