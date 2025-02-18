# NotRef - Android Application

## Overview

NotRef is an Android application built using Kotlin, Jetpack Compose, Hilt for dependency injection, and Room for persistence. This project serves as a starting point for building modern Android applications with best practices in mind.

## Tech Stack

*   **Kotlin:** The primary programming language.
*   **Jetpack Compose:** A modern UI toolkit for building native Android UIs.
*   **Hilt:** A dependency injection library that reduces the boilerplate of doing manual dependency injection in your project.
*   **Room:** A persistence library that provides an abstraction layer over SQLite.
*   **Gradle Kotlin DSL:** For build configuration.

## Prerequisites

Before you begin, ensure you have the following installed:

*   Android Studio
*   Java Development Kit (JDK) 17
*   Android SDK

## Setup Instructions

1.  **Clone the Repository:**

    ```
    git clone <repository_url>
    cd NotRef
    ```

2.  **Open in Android Studio:**

    *   Open Android Studio and select "Open an Existing Project."
    *   Navigate to the NotRef directory and open it.

3.  **Gradle Sync:**

    *   Once the project is open, Android Studio will prompt you to sync the Gradle files. Click "Sync Now."
    *   Ensure that the Gradle build completes successfully.

4.  **Build and Run:**

    *   Connect an Android device or emulator to your computer.
    *   Click the "Run" button in Android Studio to build and run the application on your device or emulator.

## Key Components

*   **`build.gradle.kts` (Top-level):** Contains configuration common to all modules.
*   **`build.gradle.kts` (App-level):** Contains configurations specific to the app module, including dependencies.
*   **`settings.gradle.kts`:** Defines the project's module structure and repository configuration.
*   **`gradle.properties`:** Specifies Gradle settings like JVM arguments and enables AndroidX.
*   **`NotRefApp.kt`:** (Assumed) The main application class, likely used for Hilt initialization.
*   **`AndroidManifest.xml`:** Describes the application's structure, components, and requirements.
*   **Compose UI:** UI elements are built using Jetpack Compose in the `app/src/main/java/...` directory.
*   **Hilt Setup:** Hilt components and modules are set up for dependency injection.
*   **Room Entities/DAOs:** Room entities and Data Access Objects (DAOs) are defined for database interactions.

## Dependencies

The project uses the following key dependencies:

*   **androidx.core:core-ktx:** Kotlin extensions for Android Core libraries.
*   **androidx.lifecycle:lifecycle-runtime-ktx:** Kotlin extensions for Android Lifecycle runtime.
*   **androidx.activity:activity-compose:** Integration of Compose with Activity.
*   **androidx.compose.\*:** Various Jetpack Compose libraries for UI development.
*   **androidx.material3:material3:** Material Design 3 components for Compose.
*   **com.google.dagger:hilt-android:** Hilt for dependency injection.
*   **androidx.hilt:hilt-navigation-compose:** Hilt integration for Compose navigation.
*   **androidx.room:room-runtime & room-ktx:** Room persistence library.

## ProGuard

The `proguard-rules.pro` file is included for configuring code shrinking and obfuscation.
