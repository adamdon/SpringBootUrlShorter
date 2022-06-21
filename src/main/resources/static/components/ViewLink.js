

export default function ViewLink()
{
    const [codeInput, setCodeInput] = useState("");
    const [codeOutput, setCodeOutput] = useState("");
    const [disabled, setDisabled] = useState(false);


    useEffect( () =>
    {
        setCodeOutput("Full URL will be shown here");
    }, [setCodeOutput]);



    async function confirmCodeOnClick()
    {
        console.log("Click!");

        setDisabled(true);
        setCodeOutput("...Loading")

        // setDisabled(false);
    }




    return(
        <div className={'alert alert-primary'}>

            <p className={'mb-0'}>Enter the Code would like to view the URL for</p>

            <div className="input-group my-3 ">
                <span className="input-group-text bg-primary text-white" >CODE: </span>
                <input value={codeInput} onChange={e => setCodeInput(e.target.value)} onKeyDown={async e => {if(e.key === "Enter") await confirmCodeOnClick()}} disabled={disabled} placeholder='Enter Code' type="text" aria-label="code" id="code" className="form-control"/>
                <button onClick={confirmCodeOnClick} disabled={disabled} className="btn btn-primary" type="button" id="submit">View</button>
            </div>
            <span>{codeOutput}</span>



        </div>
    );
}


