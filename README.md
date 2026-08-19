# MAD Practical 3: Android Intents (Implicit & Explicit)

**Course:** Mobile Application Development (MAD)  
**Enrollment No:** 24012021022  
**Package:** `com.example.a24012021022_vansh_joshi_prac3`

---

## 📖 Project Description

This project demonstrates the implementation of **Intents in Android**. It explores how an application can interact with standard Android system applications (via **Implicit Intents**) and how it handles inter-activity navigation within the same app (via **Explicit Intents**).

---

## 🌟 Core Concepts Covered

### 1. Implicit Intents
Implicit intents do not name a specific component. Instead, they declare a general action to perform, allowing a component from another app (or system app) to handle it:
- **Web Browsing:** Opens the device's web browser using `Intent.ACTION_VIEW` to load a given URL.
- **Dialer:** Launches the phone dialer with a pre-filled number using `Intent.ACTION_DIAL`.
- **Call Log:** Accesses device call history using `CallLog.Calls.CONTENT_TYPE`.
- **Image Gallery:** Opens the default photo gallery using MIME type `image/*`.
- **Camera:** Launches the camera capture interface using `MediaStore.ACTION_IMAGE_CAPTURE`.
- **Alarm Clock:** Displays configured alarms using `AlarmClock.ACTION_SHOW_ALARMS`.

### 2. Explicit Intents
Explicit intents specify the exact target component (activity) to launch:
- **Activity Navigation:** Navigates from `MainActivity` to `LoginActivity` (`Intent(this, LoginActivity::class.java)`).

---

## 📱 Screens & UI Architecture

### 1. `MainActivity` (`activity_main.xml`)
- Contains input fields for Web URLs and Phone numbers.
- Action buttons trigger corresponding implicit intents (Browse, Call, Call Log, Gallery, Camera, Alarm) and an explicit intent (Login).

### 2. `LoginActivity` (`activity_login.xml`)
- Designed using a `MaterialCardView` with rounded corners and elevation.
- Includes institute branding logo (`guni_pink_logo`), Email ID, Password fields, and Action buttons (Login & Cancel).
- Configured with Edge-to-Edge window insets for modern Android display handling.

---

## 🛠️ Summary of Intent Implementations

| Action / Button | Intent Type | Target / Action Constant | Code Snippet |
| :--- | :--- | :--- | :--- |
| **Browse Web** | Implicit | `Intent.ACTION_VIEW` | `Intent(Intent.ACTION_VIEW, Uri.parse(url))` |
| **Phone Call** | Implicit | `Intent.ACTION_DIAL` | `Intent(Intent.ACTION_DIAL).apply { data = "tel:$number".toUri() }` |
| **Call Log** | Implicit | `CallLog.Calls.CONTENT_TYPE` | `Intent(Intent.ACTION_VIEW).setType(CallLog.Calls.CONTENT_TYPE)` |
| **Gallery** | Implicit | `image/*` MIME Type | `Intent(Intent.ACTION_VIEW).setType("image/*")` |
| **Camera** | Implicit | `MediaStore.ACTION_IMAGE_CAPTURE` | `Intent(MediaStore.ACTION_IMAGE_CAPTURE)` |
| **Alarm** | Implicit | `AlarmClock.ACTION_SHOW_ALARMS` | `Intent(AlarmClock.ACTION_SHOW_ALARMS)` |
| **Login Screen** | Explicit | `LoginActivity::class.java` | `Intent(this, LoginActivity::class.java)` |

---

## 🚀 How to Run the App

1. Open the project in **Android Studio**.
2. Perform **Gradle Sync** and ensure dependencies resolve properly.
3. Run on an Android Emulator or physical device (`API 24+` recommended).
4. Test the buttons on the main screen to see system apps and internal screens open in response.

---

## 👤 Author

- **Name:** Vansh Joshi
- **Enrollment Number:** 24012021022
