

export default function ViewLink()
{
    const [codeInput, setCodeInput] = useState("");
    const [codeOutput, setCodeOutput] = useState("");
    const [disabled, setDisabled] = useState(false);
    const [showFullLink, setShowFullLink] = useState(false);



    useEffect( () =>
    {
        setCodeOutput("Full URL will be shown here...");
    }, [setCodeOutput]);



    async function confirmCodeOnClick()
    {
        console.log("confirmCodeOnClick!");
        setDisabled(true);
        setShowFullLink(false);
        setCodeOutput("...Loading URL From Code")

        const requestUrl = ("http://" + window.location.host + "/api/getLinkByCode/" + codeInput);
        const methodType = "GET"
        const requestHeaders = {"Content-Type": "application/json"};
        const initOptions = {method: methodType, headers: requestHeaders};

        try
        {
            const response = await fetch(requestUrl, initOptions);
            const jsonData = await response.json();

            if(jsonData.url && !jsonData.error)
            {
                setCodeOutput(jsonData.url);
                setShowFullLink(true);
            }
            else
            {
                setCodeOutput(jsonData.error);
            }
        }
        catch (exception)
        {
            setCodeOutput(exception.message);
        }

        setDisabled(false);
    }




    return(
        <div className={'alert alert-primary'}>

            <p className={'mb-0'}>Enter a Code (text after "link/") to preview a full URL first before loading it</p>

            <div className="input-group my-3 ">
                <span className="input-group-text bg-primary text-white" >CODE: </span>
                <input value={codeInput} onChange={e => setCodeInput(e.target.value)} onKeyDown={async e => {if(e.key === "Enter") await confirmCodeOnClick()}} disabled={disabled} placeholder='Enter Code' type="text" aria-label="code" id="code" className="form-control"/>
                <button onClick={confirmCodeOnClick} disabled={disabled} className="btn btn-primary" type="button" id="submit">View</button>
            </div>

            <div className="alert alert-secondary mb-0" role="alert" style={{"height" : "200px"}}>
                {showFullLink ?
                    <a href={codeOutput} target="_blank" rel="noopener noreferrer" type="button" className="text-decoration-none">
                        <div className={"text-wrap text-break"}>{codeOutput}</div>
                    </a>
                    :
                    <span>{codeOutput}</span>
                }
            </div>

        </div>
    );
}


