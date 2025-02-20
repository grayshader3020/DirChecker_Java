![DirChecker_Java](https://img.shields.io/badge/DirChecker_Java-%F0%9F%94%8D-blue?style=for-the-badge)

# 🚀 DirChecker_Java

**DirChecker_Java** is a powerful and sleek Java-based directory brute force scanner 🔍. Inspired by classic tools like **dirb** and **dirbuster**, this project allows you to scan web hosts for hidden directories with customizable wordlists and color-coded console output for better readability.

---

## ✨ Features

- ✅ **Fast Directory Scanning** using multi-threaded requests
- 🎨 **Color-coded console output** for status codes (200, 404, 401, 500, etc.)
- 📝 **Custom wordlist support**
- 🌐 **Protocol support**: HTTP & HTTPS
- 💥 **Clean & Readable UI** in the terminal
- 🔗 **Dynamic URL handling** with proper error checks

---

## ⚡ Installation & Usage

1. **Clone the repo:**
   ```bash
   git clone https://github.com/grayshader3020/DirChecker_Java.git
   cd DirChecker_Java
   ```

2. **Compile the Java code:**
   ```bash
   javac dirbScanner.java
   ```

3. **Run the tool:**
   ```bash
   java dirbScanner
   ```

4. **Provide input:**
   - When prompted, enter the target URL (with protocol):
     ```
     https://example.com
     ```

5. **Output Example:**
   ```
   [+] Wordlist read. Starting the dirb process...[*]
   Scanning: https://example.com/robots.txt
   \u001B[32m[200 OK] Found: robots.txt\u001B[0m
   Scanning: https://example.com/admin
   \u001B[31m[404 Not Found] Dir Not available: admin\u001B[0m
   ```

---

## 💡 How It Works

1. Reads a **custom wordlist** (`common.txt` by default).
2. Iteratively appends each entry to the **base URL**.
3. Sends **HTTP GET** requests using `HttpURLConnection`.
4. Displays **color-coded results** based on HTTP status codes.

---

## 🎨 Console Color Codes

| Status Code | Meaning                  | Color  |
|-------------|--------------------------|---------|
| 200         | OK (Directory Found)      | 🟩 Green |
| 404         | Not Found                 | 🟥 Red   |
| 401         | Unauthorized              | 🟨 Yellow|
| 500         | Internal Server Error     | 🟦 Blue  |
| Others      | Other Response            | 🟦 Cyan  |

---

## 🛠️ Contributing

Pull requests are welcome! 🚀 For major changes, please open an issue first to discuss what you would like to change.

1. Fork the project
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a pull request

---

## ⚖️ License

Distributed under the **MIT License**. See [`LICENSE`](LICENSE) for more information.

---

## ✍️ Author

👨‍💻 **Grayshader3020**  
🔗 [GitHub Profile](https://github.com/grayshader3020)

---

## ⭐ Show Your Support

If you like this project:

- ⭐ **Star** the repo
- 🍴 **Fork** it
- 📝 **Share** feedback and suggestions

> _"Code, Scan, Discover – Let no directory remain hidden!"_ 🚀

