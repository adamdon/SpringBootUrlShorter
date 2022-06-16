

const { useState } = React;
export default function Home()
{
    const [test, setTest] = useState("here");

    return(
        <div>
            <h1>Hello home</h1>
            <p>{test}</p>
        </div>
    );
}


