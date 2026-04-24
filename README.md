# Advanced Wealth Tracker – Giorgi Khizanashvili
 Student Information
- **Name:** Giorgi  
- **Surname:** Khizanashvili  
- **Birth date:** 28 October (day = 28)  

 K Coefficient Calculation
**Formula:**  
`K = (first name letters + last name letters) / birth day`

- First name "Giorgi" → **6** letters  
- Last name "Khizanashvili" → **13** letters  
- Birth day → **28**  

**K = (6 + 13) / 28 = 19 / 28 = 0.67857142857**
 Dynamic Orientation (ViewPager2)
Surname `Khizanashvili` starts with the letter **K** – a **consonant**.  
According to the assignment rule:  
- Consonant → **Vertical** scrolling  
- Vowel → Horizontal scrolling  

**Result:** The ViewPager2 orientation is **VERTICAL**.
Naming Convention (Anti‑Copy rule)
- Initials: `G` (Giorgi) + `K` (Khizanashvili) → `GK`  
- Last two letters of surname: `li`  
- **Prefix for all IDs:** `gk_li_`  

Examples:  
- `gk_li_et_income` (income EditText)  
- `gk_li_btn_save` (save Button)  
- `gk_li_viewPager` (ViewPager2)  
App Features
- **Single Activity** architecture  
- **ViewPager2** with **TabLayout** (3 tabs)  
- **Fragment Result API** for data exchange (no ViewModel)  
- **WealthManager** class – contains all mathematical logic  
- **ConstraintLayout** on every screen  
- Input validation with `setError`  
How to Run
1. Clone this repository or open the project in Android Studio.  
2. Wait for Gradle sync to complete.  
3. Connect an Android device (USB debugging enabled) or start an emulator (API 21+).  
4. Click the **Run** button (green triangle) or press `Shift + F10`.  
5. The app will install and launch automatically.  
Testing the App
| Tab | Action | Expected Result |
|-----|--------|------------------|
| **Input** | Enter Income (e.g., 1000) and Expenses (e.g., 300). Tap “შენახვა”. | No errors, data saved. |
| **Analytics** | Switch to this tab. | Shows “დაზოგვა: 475.0” (because (1000‑300)*0.6786 ≈ 475). |
| **Profile** | Switch to this tab. | Displays name, surname, birth day, and K ≈ 0.6786. |

**Navigation:** Swipe **vertically** (up/down) to switch between tabs.

Project Structure (key files)
