export default function loadScript(url, id = "") {
  let script = window.document.createElement("script");
  let index = window.document.getElementsByTagName("script")[0];
  if (id !== "")
    script.id = id;
  script.src = url;
  script.async = true;
  script.defer = true;
  index.parentNode.insertBefore(script, index);
}
