class Codec
{
	static final Map<String, String> map = new HashMap<>();
    static final String BASE_HOST = "http://tinyurl.com/";

    public String encode(String longUrl)
	{
		String shortUrl = BASE_HOST + longUrl.hashCode();
		map.put(shortUrl, longUrl);
		return shortUrl;
    }

    public String decode(String shortUrl)
	{
		return map.get(shortUrl);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));