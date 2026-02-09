// Basically a superset of v-- vite config with tests baked in
import { defineConfig } from "vitest/config";
import react from "@vitejs/plugin-react";


// https://vite.dev/config/
export default defineConfig({
  plugins: [react()],
  
  // Vitest config
  test: {
    globals: true, // allows for global test functions describe(), it(), expect()
    environment: "jsdom",  // Creates a virtualized virtualdom for us to run our tests with
    setupFiles: "./src/tests/setupTests.ts"
  }
})
