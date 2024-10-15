import { defineConfig } from "vite";
import react from "@vitejs/plugin-react";
import { config } from "dotenv";

// DOTENV
config();

// https://vitejs.dev/config/
export default defineConfig({
  "process.env": process.env,
  plugins: [react()],
});
