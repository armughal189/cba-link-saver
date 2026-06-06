# CBA Link Saver 🔗

[![Android Platform](https://img.shields.io/badge/Platform-Android-3DDC84?logo=android&logoColor=white&style=flat-squared)](https://developer.android.com/)
[![Kotlin](https://img.shields.io/badge/Kotlin-2.1.20-7F52FF?logo=kotlin&logoColor=white&style=flat-squared)](https://kotlinlang.org/)
[![Jetpack Compose](https://img.shields.io/badge/Compose-Material%203-4285F4?logo=jetpackcompose&logoColor=white&style=flat-squared)](https://developer.android.com/compose)
[![Room Database](https://img.shields.io/badge/Room-3.0.0--alpha05-3DDC84?style=flat-squared)](https://developer.android.com/training/data-storage/room)
[![Koin DI](https://img.shields.io/badge/Koin-4.2.1-FFC107?style=flat-squared)](https://insert-koin.io/)

**CBA Link Saver** is an accessibility-first Android application designed to make saving, managing, and sharing web links effortless for everyone—specifically optimized for blind and visually impaired users. Built using **Jetpack Compose**, **Kotlin**, and **Clean Architecture**, it adheres to high-quality software engineering principles while prioritizing screen-reader compatibility (e.g., TalkBack, Jieshuo).

---

## 🌟 Key Features

*   **Quick Save & Edit:** Store web links along with custom titles and descriptions.
*   **Accessibility Action Focus:** Uses custom Android Accessibility Actions for managing links (Open, Copy, Share, Update, Delete) instead of complex, hard-to-navigate context menus.
*   **Highly Accessible Dialogs:** Incorporates Views-based Dialogs alongside Jetpack Compose to guarantee seamless compatibility and focus-stability for screen readers.
*   **Adaptive Theme Support:** Automatic dark, light, and system-default themes configurable from settings.
*   **Customizable Sharing:** Choose to share links with their custom titles or share URLs exclusively.
*   **Modern Adaptive Navigation:** Uses experimental **AndroidX Navigation 3** and the **Adaptive Navigation Suite** to deliver fluid layouts across different screen configurations (phones, tablets, foldables).
*   **Clean Database Operations:** A built-in Settings utility to clear the database and reset keys safely.

---

## 🛠️ Architecture & Tech Stack

CBA Link Saver is engineered with scalability, separation of concerns, and accessibility in mind:

*   **Programming Language:** 100% Kotlin.
*   **UI Framework:** Jetpack Compose (Material 3) with `NavigationSuiteScaffold` for adaptive, multi-pane UI setups.
*   **Navigation:** AndroidX Navigation 3 (`navigation3-runtime`, `navigation3-ui`).
*   **Local Storage:** **Room Database 3** (Kotlin Multiplatform/Alpha) for local SQL caching, built with Kotlin Symbol Processing (KSP).
*   **Dependency Injection:** **Koin** (BOM 4.2.1) + **Koin Annotations** for compiling compile-time safe dependency trees.
*   **Serialization:** Kotlinx Serialization for type-safe route navigation arguments.

---

## ♿ Complete Blind Accessibility (CBA) & `reuse_hub`

The core highlight of this project is the `reuse_hub` package located inside the codebase. Jetpack Compose sometimes poses focus order and traversal challenges for advanced screen readers like **Jieshuo** or traditional **TalkBack**. 

To address this, `reuse_hub` provides:
1.  **CbaTextView, CbaButton, CbaLayout:** Wrapper widgets pre-configured with explicit accessibility labels, heading flags, and target focus ordering.
2.  **Android Views Dialog Bridges:** Wrappers that project Compose UI contents into traditional Android Views dialogs to prevent screen readers from getting stuck inside Compose navigation backstacks.
3.  **Actionable Node Info:** Accessibility actions mapped directly to system-level gestures, avoiding long-press dependency.

---

## 📂 Project Structure

```
cba-link-saver/
│
├── app/
│   ├── src/
│   │   └── main/
│   │       ├── AndroidManifest.xml
│   │       ├── java/io/multidev134/
│   │       │   ├── link_saver/
│   │       │   │   ├── MainActivity.kt        # Entry Point & NavigationSuite Setup
│   │       │   │   ├── MainApplication.kt     # App Class, Koin Initialization
│   │       │   │   ├── core/                  # Shared Models, Database, and ViewModels
│   │       │   │   └── features/              # Feature Screens (list, details, settings, more)
│   │       │   │
│   │       │   └── reuse_hub/                 # Accessibility-first Core Widget Library
│   │       │       ├── ui/widget/             # CbaLayout, CbaButton, CbaTextView, CbaClickableView
│   │       │       └── utils/                 # Clipboard, Url Validation, Share utils
│   │       │
│   │       └── res/                           # Android Layout & Drawable resources
│   │
│   └── build.gradle.kts                       # Module-specific dependencies & configuration
│
├── gradle/libs.versions.toml                  # Version catalog containing latest versions
└── build.gradle.kts                           # Root gradle configuration
```

---

## 🚀 Getting Started

### Prerequisites

*   Android Studio Ladybug (2024.2.1) or newer
*   JDK 17 or higher
*   Android SDK 28+ (Compile & Target SDK: 37)

### Installation

1.  **Clone the Repository:**
    ```bash
    git clone https://github.com/armughal189/cba-link-saver.git
    cd cba-link-saver
    ```

2.  **Build the Project:**
    Open the project in Android Studio, allow Gradle to sync, and click **Build > Make Project**.

3.  **Run the App:**
    Connect your Android device or start an emulator, then click **Run 'app'**.

---

## 🤝 Contributing

Contributions to improve accessibility integrations, UI designs, or performance are welcome!
1. Fork the Project.
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`).
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`).
4. Push to the Branch (`git push origin feature/AmazingFeature`).
5. Open a Pull Request.

---

## 📄 License

This project is licensed under the MIT License. See the `LICENSE` file for details (if applicable).
