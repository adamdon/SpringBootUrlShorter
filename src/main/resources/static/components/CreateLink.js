

export default function CreateLink()
{
    const [urlInput, setUrlInput] = useState("");
    const [urlOutput, setUrOutput] = useState("");
    const [disabled, setDisabled] = useState(false);
    const [showLink, setShowLink] = useState(false);


    useEffect( () =>
    {
        setUrOutput("Shortened URL will show here...");
    }, [setUrOutput]);



    async function confirmUrlOnClick()
    {
        console.log("confirmUrlOnClick!");
        setDisabled(true);
        setShowLink(false);
        setUrOutput("...Loading")

        // const requestUrl = ("" + window.location.protocol + window.location.host + "/api/createLink/");
        const requestUrl = ("" + window.location.protocol + "/api/createLink/");
        const methodType = "POST"
        const requestHeaders = {"Content-Type": "application/json"};
        const requestBody = {url: urlInput};
        const initOptions = {method: methodType, headers: requestHeaders, body: JSON.stringify(requestBody)};

        try
        {
            const response = await fetch(requestUrl, initOptions);
            const jsonData = await response.json();

            if(jsonData.code && !jsonData.error)
            {
                const shortenedUrl = ("http://" + window.location.host + "/link/" + jsonData.code);
                setUrOutput(shortenedUrl);
                setShowLink(true);
            }
            else
            {
                setUrOutput(jsonData.error);
            }
        }
        catch (exception)
        {
            setUrOutput(exception.message);
        }

        setDisabled(false);
    }




    return(
        <div className={'alert alert-primary'}>

            <p className={'mb-0'}>Enter a URL you would like to make smaller</p>

            <div className="input-group my-3 ">
                <span className="input-group-text bg-primary text-white" >URL: </span>
                <input value={urlInput} onChange={e => setUrlInput(e.target.value)} onKeyDown={async e => {if(e.key === "Enter") await confirmUrlOnClick()}} disabled={disabled} placeholder='Enter Address' type="url" aria-label="url" id="url" className="form-control"/>
                <button onClick={confirmUrlOnClick} disabled={disabled} className="btn btn-primary" type="button" id="submit">Shorten</button>
            </div>
            <div className="alert alert-secondary mb-0" role="alert">
                {showLink ?
                    <a href={urlOutput} target="_blank" rel="noopener noreferrer" type="button" className="text-decoration-none">
                        <span>{urlOutput}</span>
                    </a>
                    :
                    <span>{urlOutput}</span>
                }
            </div>

        </div>
    );
}


