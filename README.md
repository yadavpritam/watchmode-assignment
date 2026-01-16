## Watchmode Android Assignment

Android application built using Watchmode API.
The app displays Movies and TV Shows using Jetpack Compose with MVVM architecture.

---

## Features Implemented

- Fetch Movies and TV Shows from Watchmode API
- Toggle between Movies and TV Shows
- Text-based Home Screen (no poster dependency)
- Detail Screen
  - Title details
  - Back navigation
  - Share functionality
- Shimmer loading effect
- Graceful error handling
- Navigation using Jetpack Navigation Compose

---

## Tech Stack

- Kotlin
- Jetpack Compose
- MVVM Architecture
- Retrofit + OkHttp
- RxJava3
- Hilt (Dependency Injection)
- Coil
- Navigation Compose

---

## Architecture

- View → Jetpack Compose UI
- ViewModel → Business logic & state
- Repository → API handling
- State → StateFlow

---

## Assumptions

- Poster images may be missing from API
- UI does not depend on posters
- Recommendation section uses filtered data
- Streaming playback not implemented

---

## Challenges Faced

- Missing poster data
- API timeout on slow internet
- Navigation arguments in Compose
- Clean UI without images

---

## How to Run

- Clone repository
- Open in Android Studio
- Add Watchmode API key
- Run on emulator or device

---

## APK & Demo Video

- APK: Shared in submission
- Demo Video: Shared via Google Drive

---

## Network Note

- Fast internet → API works fine
- Slow internet → Timeout may occur
- App handles loading & error states properly

---

## Test Cases

### Test Case 1
- Input: App launch
- Expected: Shimmer loading
- Result: Home screen loads
- Status: Pass

### Test Case 2
- Input: Toggle Movies / TV Shows
- Expected: List updates
- Result: Correct data shown
- Status: Pass

### Test Case 3
- Input: Click on movie/show
- Expected: Navigate to details
- Result: Details screen opens
- Status: Pass

### Test Case 4
- Input: Back button
- Expected: Return to Home
- Result: Works correctly
- Status: Pass

### Test Case 5
- Input: Slow network
- Expected: Error / loading state
- Result: No crash
- Status: Pass

---

## Developer

Pritam Yadav
