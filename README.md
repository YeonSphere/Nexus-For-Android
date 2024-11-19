# Nexus Browser for Android

[![CI](https://github.com/YeonSphere/Nexus-For-Android/actions/workflows/ci.yml/badge.svg)](https://github.com/YeonSphere/Nexus-For-Android/actions/workflows/ci.yml)
[![API](https://img.shields.io/badge/API-23%2B-brightgreen.svg)](https://android-arsenal.com/api?level=23)
[![License](https://img.shields.io/badge/License-YUOSL-purple)](LICENSE)
[![Android](https://img.shields.io/badge/Platform-Android-green.svg)](https://www.android.com)
[![Kotlin](https://img.shields.io/badge/Kotlin-1.9.22-blue.svg)](https://kotlinlang.org)

This is an Android browser application developed with Kotlin and Jetpack Compose, focusing on privacy and user control.

## Features

* Advanced web browsing functionality
* Intuitive address bar for URL entry and search
* Efficient tab management with multi-window support
* Customizable settings for personalized browsing experience
* Robust ad blocking and tracker prevention (compliant with US federal laws)
* Enhanced bookmarks system with folder organization
* Comprehensive browsing history with search and delete options
* Private browsing mode
* Built-in download manager
* Support for extensions (in development)

## Development

This project is actively under development. Contributions are welcome with permission from the Owner/CEO. For inquiries, contact daedaevibin@naver.com or join our Discord server (link to be provided).

## Build Instructions

1. Clone the repository: `git clone https://github.com/YeonSphere/Nexus-For-Android.git`
2. Open the project in Android Studio Arctic Fox or later.
3. Sync the project with Gradle files.
4. Ensure you have the latest Android SDK and Kotlin plugin installed.
5. Build and run the app on an emulator or physical device running Android 6.0 (API level 23) or higher.

## Testing

1. Run unit tests: `./gradlew test`
2. Run instrumented tests: `./gradlew connectedAndroidTest`
3. For UI tests: `./gradlew connectedAndroidTest -Pandroid.testInstrumentationRunnerArguments.class=com.yeonsphere.nexus.ui.tests.UITestSuite`

## Contributing

Please read our [CONTRIBUTING.md](CONTRIBUTING.md) file for details on our code of conduct, development process, and the procedure for submitting pull requests. All contributions must adhere to our coding standards and pass all tests.

## License

This project is licensed under the YeonSphere Universal Open Source License (YUOSL). Key points:
- Free for personal use
- Commercial terms negotiable
- 30-day response window for inquiries
- Contact @daedaevibin for commercial licensing
- See the [LICENSE](LICENSE) file for full details

## Contact

- Primary Contact: Jeremy Matlock (@daedaevibin)
- Email: daedaevibin@naver.com
