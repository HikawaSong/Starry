
export const httpPost = async <T = any> (url: string, data: any): Promise<T> => {
    const res = await fetch(url, {
        method: 'POST',
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify(data)
    })

    if(!res.ok) throw new Error(await res.text());
    const json = await res.json() as T;
    return json;
}