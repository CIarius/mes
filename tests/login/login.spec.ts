import { test, expect } from '@playwright/test';

test('Login page renders and handles invalid login', async ({ page }) => {

  await page.goto('http://localhost:8080/mes/login.jsp');

  await expect(page.getByRole('heading', { name: 'Login to Your Dashboard' })).toBeVisible();

  await page.fill('#username', 'wronguser');
  await page.fill('#password', 'wrongpass');
  await page.click('button[type="submit"]');

  await expect(page.getByText('Invalid username or password.')).toBeVisible();
  
});
