# Watchmode Android Assignment

This project is an Android application built using the Watchmode API.  
The app displays Movies and TV Shows using Jetpack Compose with an MVVM-based architecture.

---

## Project Overview

- Platform: Android
- Language: Kotlin
- UI: Jetpack Compose
- Architecture: MVVM
- API: Watchmode API

---

## Features Implemented

- Fetch Movies and TV Shows using Watchmode API
- Toggle between Movies and TV Shows
- Home screen with clean text-based list UI
- Detail screen with:
  - Title information
  - Description
  - Back navigation
  - Share functionality
- Shimmer loading UI while data is loading
- Graceful error handling for API failures
- Navigation using Jetpack Navigation Compose

---

## Tech Stack

- Kotlin
- Jetpack Compose
- MVVM Architecture
- Retrofit
- RxJava3
- Hilt (Dependency Injection)
- Coil (optional image handling)
- Navigation Compose

---

## Architecture

The application follows MVVM architecture:

- View: Jetpack Compose UI
- ViewModel: Handles state and business logic
- Repository: Handles API calls
- State Management: StateFlow

---

## Assumptions

- Poster images are not mandatory on the Home screen, so the UI focuses on text-based content.
- Recommendation section uses filtered data from already fetched titles.
- Video streaming is not implemented (UI and navigation only).

---

## Challenges Faced

- Handling missing or incomplete data from the API
- Managing navigation arguments in Jetpack Compose
- Handling slow network conditions and API timeouts
- Designing a clean UI without heavy image dependency

---

## Network Limitation Note

During testing, it was observed that the Watchmode API may occasionally timeout on slow or unstable internet connections.

- On a stable and fast connection, the API responds correctly.
- On slower connections, timeout errors may occur.

The app handles this gracefully by showing loading and error states without crashing.

---

## How to Run the Project

1. Clone the repository
2. Open the project in Android Studio
3. Add your Watchmode API key
4. Run the app on an emulator or physical device

---

## APK

- Debug APK is included in the repository under the `apk/` folder  
- File name: `app-debug.apk`

---

## Demo Video (Code Walkthrough & Testing)

Google Drive link:

https://drive.google.com/file/d/1RaYJQTEtE1o95mAnN3pNpQtYvXXgqZt1/view?usp=drivesdk

The video demonstrates:
- App launch with shimmer loading
- Movies / TV Shows toggle
- Navigation to detail screen
- Back navigation
- Share functionality

---

## Test Cases

### Test Case 1: App Launch
- Input: Launch application
- Expected Result: Shimmer loading UI appears
- Result: Pass

### Test Case 2: Toggle Movies / TV Shows
- Input: Switch tabs
- Expected Result: Correct list loads
- Result: Pass

### Test Case 3: Open Details Screen
- Input: Click on any movie or TV show
- Expected Result: Details screen opens
- Result: Pass

### Test Case 4: Back Navigation
- Input: Press back button on details screen
- Expected Result: Navigate back to home screen
- Result: Pass

### Test Case 5: Slow Network / API Failure
- Input: Use slow internet connection
- Expected Result: Loading or error state shown
- Result: Pass

---

## Developer

Name: Pritam Yadav
